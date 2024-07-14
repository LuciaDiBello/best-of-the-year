package it.bestoftheyear.controller;

import java.util.ArrayList;
import java.util.List;

import it.bestoftheyear.model.Song;
import it.bestoftheyear.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class ControllerList {

		private List<Movie> getBestMovies() {
			List<Movie> movies = new ArrayList<>();
			Movie movie1 = new Movie(1, "TitoloFilm1");
			Movie movie2 = new Movie(2, "TitoloFilm2");
			Movie movie3 = new Movie(3, "TitoloFilm3");
			Movie movie4 = new Movie(4, "TitoloFilm4");
			Movie movie5 = new Movie(5, "TitoloFilm5");
			movies.add(movie1);
			movies.add(movie2);
			movies.add(movie3);
			movies.add(movie4);
			movies.add(movie5);
			return movies;
		}
		
		private List<Song> getBestSongs() {
			List<Song> songs = new ArrayList<>();
			Song songs1= new Song(1,"TitoloCanzone1");
			Song songs2= new Song(2,"TitoloCanzone2");
			Song songs3= new Song(3,"TitoloCanzone3");
			Song songs4= new Song(4,"TitoloCanzone4");
			Song songs5= new Song(5,"TitoloCanzone5");
			songs.add(songs1);
			songs.add(songs2);
			songs.add(songs3);
			songs.add(songs4);
			songs.add(songs5);
			return songs;
		}
		
		
		@GetMapping("/")
		public String index() {
			return "index";
		}
		
		
		@GetMapping("/movies")
		public String movies(Model model) {
			List<Movie> listMovies = getBestMovies();
			model.addAttribute("listMovies", listMovies);
			return "movies";
		}

		@GetMapping("/songs")
		public String songs(Model model) {
			List<Song> listSongs = getBestSongs();
			model.addAttribute("listSongs", listSongs);
			return "songs";
		}		

		@GetMapping("/movies/{id}")
		public String moviebyId(@PathVariable(name = "id") int id, Model model) {
			List<Movie> listMovies = getBestMovies();
			for (int i = 0; i < listMovies.size(); i++) {
				if (listMovies.get(i).getId() == id) {
					model.addAttribute("movie",listMovies.get(i));
				}
			}
			return "moviebyId";
		}
		
		
		@GetMapping("/songs/{id}")
		public String songsbyId(@PathVariable(name = "id") int id, Model model) {
			List<Song> listSongs = getBestSongs();
			for (int i = 0; i < listSongs.size(); i++) {
				if (listSongs.get(i).getId() == id) {
					model.addAttribute("song",listSongs.get(i));
				}
			}
			return "songbyId";
		}
}

		