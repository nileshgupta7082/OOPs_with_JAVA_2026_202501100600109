import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Movie {
    int movieId;
    String name;
    double rating;

    Movie(int movieId, String name, double rating) {
        this.movieId = movieId;
        this.name = name;
        this.rating = rating;
    }

    void display() {
        System.out.println(movieId + "  " + name + "  " + rating);
    }
}

public class MovieRatingSystem {
    public static void main(String[] args) {

        ArrayList<Movie> movies = new ArrayList<>();

        movies.add(new Movie(101, "Inception", 8.8));
        movies.add(new Movie(102, "The Dark Knight", 9.0));
        movies.add(new Movie(103, "Interstellar", 8.6));
        movies.add(new Movie(104, "The Matrix", 8.7));

        // Sort using Comparator
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie m1, Movie m2) {
                return Double.compare(m2.rating, m1.rating); // Sort by rating in descending order
            }
        });

        System.out.println("Movie Ratings:");
        System.out.println("ID  Name  Rating");

        for (Movie m : movies) {
            m.display();
        }
    }
}