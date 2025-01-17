package com.xandy.workshopspringmongo.config;

import com.xandy.workshopspringmongo.domains.Post;
import com.xandy.workshopspringmongo.domains.User;
import com.xandy.workshopspringmongo.dto.AuthorDTO;
import com.xandy.workshopspringmongo.repository.PostRepository;
import com.xandy.workshopspringmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instatiantion implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        postRepository.deleteAll();
        Post p1 = new Post(null, sdf.parse("21/09/2021"), "Partiu Viagem", "Viajar para Marrocos", new AuthorDTO(maria));
        Post p2 = new Post(null, sdf.parse("02/03/2018"), "Bom dia", "Acordei Feliz HJ", new AuthorDTO(maria));
        Post p3 = new Post(null, sdf.parse("11/11/2011"), "Post Title 3", "Post Body 1234", new AuthorDTO(alex));
        postRepository.saveAll(Arrays.asList(p1, p2, p3));

    }
}
