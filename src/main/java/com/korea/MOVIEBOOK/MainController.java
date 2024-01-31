package com.korea.MOVIEBOOK;
import com.korea.MOVIEBOOK.book.Book;
import com.korea.MOVIEBOOK.book.BookService;
import com.korea.MOVIEBOOK.drama.Drama;
import com.korea.MOVIEBOOK.drama.DramaService;
import com.korea.MOVIEBOOK.movie.movie.Movie;
import com.korea.MOVIEBOOK.movie.movie.MovieService;
import com.korea.MOVIEBOOK.webtoon.webtoonList.Webtoon;
import com.korea.MOVIEBOOK.webtoon.webtoonList.WebtoonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final BookService bookService;
    private final DramaService dramaService;
    private final MovieService movieService;
    private final WebtoonService webtoonService;

    @GetMapping("/test")
    public String aaaa() {
        return "test";
    }
    @GetMapping("/search")
    public String searchList(Model model,
                             @RequestParam(value = "page", defaultValue = "0") int page,
                             @RequestParam(value = "kw", defaultValue = "") String kw){


        Page<Movie> pagingMovie = movieService.getMovieList(page, kw);
        Page<Drama> pagingDrama = dramaService.getDramaList(page, kw);
        Page<Book> pagingBook = bookService.getBookList(page, kw);
        Page<Webtoon> pagingWebtoon = webtoonService.getWebtoonList(page, kw);


        model.addAttribute("pagingWebtoon", pagingWebtoon);
        model.addAttribute("pagingmovie", pagingMovie);
        model.addAttribute("pagingDrama", pagingDrama);
        model.addAttribute("pagingBook", pagingBook);
        model.addAttribute("spec", kw);

        return "search_list";
    }

    @GetMapping("/")
    public String test() {
        return "mainPage";
    }
}
