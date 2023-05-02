package com.sdaproject.bookclubpro.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.IntToLongFunction;
import java.util.function.ToLongFunction;

import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.sdaproject.bookclubpro.Entity.Book;
import com.sdaproject.bookclubpro.Entity.Club;
import com.sdaproject.bookclubpro.Entity.Genre;
import com.sdaproject.bookclubpro.Entity.Person;
import com.sdaproject.bookclubpro.Entity.ReadingList;
import com.sdaproject.bookclubpro.Repository.BookRepository;
import com.sdaproject.bookclubpro.Serivce.BookService;
import com.sdaproject.bookclubpro.Serivce.ClubService;
import com.sdaproject.bookclubpro.Serivce.PersonService;

@Controller
public class AppController {

    private Person verificatonPerson;
    private PersonService personService;
    private BookService bookService;
    private ClubService clubService;

    public AppController(PersonService personService, BookService bookService, ClubService clubService) {
        this.personService = personService;
        this.bookService = bookService;
        this.clubService = clubService;
    }

    private boolean ifVerified(Person p) {

        if (p.getEmail().equals(verificatonPerson.getEmail())
                && p.getPassword().equals(verificatonPerson.getPassword()))
            return true;

        return false;
    }

    @GetMapping("/viewbook/{id}")
    public ResponseEntity<ByteArrayResource> getPdf(@PathVariable("id") Long id) throws IOException {
        Path pdfPath = Paths.get("C:/programming files/books/" + Long.toString(id) + ".pdf");

        byte[] bytes = Files.readAllBytes(pdfPath);
        ByteArrayResource resource = new ByteArrayResource(bytes);

        return ResponseEntity.ok()
                .contentLength(bytes.length)
                .contentType(MediaType.parseMediaType("application/pdf"))
                .body(resource);
    }

    private String getLink(Person p, String link) {

        verificatonPerson = personService.getPersonData(p);

        if (verificatonPerson != null) {

            if (this.ifVerified(p)) {

                int userType = personService.getType(verificatonPerson);

                if (userType == 0) {
                    return "redirect:/admin" + link;
                } else if (userType == 1) {
                    return "redirect:/user" + link;
                } else if (userType == 2) {
                    return "redirect:/publisher" + link;
                } else if (userType == 3) {
                    return "redirect:/author" + link;
                } else if (userType == 4) {
                    return "redirect:/judge" + link;
                }
            }
        }

        return "login_page";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/login";
    }

    @GetMapping("/signup")
    public String SignupPageGetMap(Model model) {

        Person person = new Person();
        int userType = 0;

        model.addAttribute("person", person);
        model.addAttribute("userType", userType);

        return "signup_page";
    }

    @PostMapping("/signup")
    public String SignupPagePostMap(@ModelAttribute(value = "person") Person person,
            @ModelAttribute(value = "userType") int userType, Model model) {

        if (userType == 1) {
            // create simple user and save
        } else if (userType == 2) {
            // create publisher and save
        } else if (userType == 3) {
            // create author and save
        } else if (userType == 4) {
            // create judge and save
        }

        return "login_page"; // change this later accordingly
    }

    @GetMapping("/login")
    public String loginPageGetMap(Model model) {

        Person p = new Person();

        model.addAttribute("p", p);

        return "login_page";
    }

    @PostMapping("/login")
    public String loginPagePostMap(@ModelAttribute(value = "p") Person p, Model model) {

        return this.getLink(p, "/homepage");
    }

    @GetMapping("/logout")
    public String logOutGetMap() {

        this.verificatonPerson = null;

        return "redirect:/login";
    }

    @GetMapping("/admin/homepage")
    public String adminHomePage(Model model) {

        if (verificatonPerson == null) {
            return "redirect:/login";
        } else {
            verificatonPerson = personService.getPersonData(verificatonPerson);

            if (personService.getType(verificatonPerson) == 0) {
                return "admin/admin_homepage";
            } else {
                return "redirect:/login";
            }
        }
    }

    @GetMapping("user/homepage")
    public String userHomePage(Model model) {

        if (verificatonPerson == null) {
            return "redirect:/login";
        } else {

            int userType = personService.getType(verificatonPerson);

            if (userType == 1) {
                return "user/user_homepage";
            } else {
                return "redirect:/login";
            }
        }
    }

    @GetMapping("publisher/homepage")
    public String publisherHomePage(Model model) {

        if (verificatonPerson == null) {
            return "redirect:/login";
        } else {
            verificatonPerson = personService.getPersonData(verificatonPerson);

            if (personService.getType(verificatonPerson) == 2) {
                return "publisher/publisher_homepage";
            } else {
                return "redirect:/login";
            }
        }
    }

    @GetMapping("author/homepage")
    public String authorHomePage(Model model) {

        if (verificatonPerson == null) {
            return "redirect:/login";
        } else {
            verificatonPerson = personService.getPersonData(verificatonPerson);

            if (personService.getType(verificatonPerson) == 3) {
                return "author/author_homepage";
            } else {
                return "redirect:/login";
            }
        }
    }

    @GetMapping("judge/homepage")
    public String judgeHomePage(Model model) {

        if (verificatonPerson == null) {
            return "redirect:/login";
        } else {

            if (personService.getType(verificatonPerson) == 4) {
                return "author/author_homepage";
            } else {
                return "redirect:/login";
            }
        }
    }

    @GetMapping("/user/ReadingList")
    public String userReadingListPage(Model model) {

        if (verificatonPerson == null) {
            return "redirect:/login";
        }

        ReadingList readingList = new ReadingList();

        readingList.setBookList(bookService.getBookList(verificatonPerson.getId()));

        model.addAttribute("bookList", readingList.getList());

        Book searchBook = new Book();

        model.addAttribute("searchBook", searchBook);

        return "user/user_readinglist";

    }

    @GetMapping("/user/ReadingList/{id}")
    public String deleteUserBookFromList(@PathVariable Long id, Model model) {

        System.out.println("pId : " + verificatonPerson.getId());
        System.out.println("bId : " + id);

        bookService.removeBookFromList(verificatonPerson.getId(), id);

        return "redirect:/user/ReadingList";
    }

    @GetMapping("/about")
    public String aboutPageGetMap() {

        return "about";
    }

    @GetMapping("/searchbook{searchWord}")
    public String searchBookGetMap(@PathVariable String searchWord, @ModelAttribute("searchBook") Book searchBook,
            Model model) {

        List<Book> searchResultBook = bookService.getBookWhenSearched(searchBook.getTitle());

        model.addAttribute("searchResultBook", searchResultBook);
        return "book_search";
    }

    @GetMapping("/searchbook/addbook/{id}")
    public String addBookGetMap(@PathVariable Long id, Model model) {

        ReadingList readingList = new ReadingList();

        readingList.setBookList(bookService.getBookList(verificatonPerson.getId()));

        for (int i = 0; i < readingList.getNumberOfBook(); i++) {

            if (readingList.getList().get(i).getId() == verificatonPerson.getId()) {
                return "redirect:/user/ReadingList";
            }
        }

        bookService.saveBookToPerson(verificatonPerson.getId(), id);

        return "redirect:/user/ReadingList";
    }

    @GetMapping("/addmore")
    public String addMoreGetMap(Model model) {

        Book searchBook = new Book();

        model.addAttribute("searchBook", searchBook);

        return "addmore.html";
    }

    @GetMapping("/club")
    public String clubHomepageGetMap(Model model) {

        // here we check if user is already in some club, if yes go to club homepage, if
        // not go to create club

        Club nClub = new Club();
        // System.out.println("Genre : " + nClub.get(0).getGenreList().get(0));
        Date date = new Date();
        List<Genre> ll = new ArrayList<Genre>();

        ll.add(Genre.Comic);
        ll.add(Genre.Romance);

        nClub.setName("AhmadA Club");
        nClub.setCreationDate(date);
        nClub.setTagline("Books for all");
        nClub.setGenreList(ll);

        clubService.createClub(nClub);

        return "club/create_club.html";
    }

    @GetMapping("/club/joinclub")
    public String joinClubGetMap(Model model) {

        List<Club> clubList = clubService.getAllClub();

        model.addAttribute("clubList", clubList);

        Book searchBook = new Book();

        model.addAttribute("searchBook", searchBook);

        return "club/join_club.html";
    }

}

/*------------------------------------------------------------------------------------ */

/*
 * 0 - admin
 * 1 - user
 * 2 - publisher
 * 3 - author
 * 4 - judge
 */