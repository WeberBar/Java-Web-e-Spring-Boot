package br.com.alura.screanmatch;

import br.com.alura.screanmatch.model.DadosSerie;
import br.com.alura.screanmatch.service.ConsumoApi;
import br.com.alura.screanmatch.service.ConverterDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
public class ScreanmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreanmatchApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        var consumoApi = new ConsumoApi();
        var json = consumoApi.obterDados("http://www.omdbapi.com/?t=stranger+things&apikey=f113b4b5");
        ConverterDados conversor = new ConverterDados();
        DadosSerie dadosSerie = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dadosSerie);

    }


}
