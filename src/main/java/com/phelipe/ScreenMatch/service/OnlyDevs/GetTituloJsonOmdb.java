package com.phelipe.ScreenMatch.service.OnlyDevs;


import com.phelipe.ScreenMatch.Exception.ExceptionTitulo.ExceptionGetTituloJsonOmdb;
import com.phelipe.ScreenMatch.model.modelTitulo.EntityMedia;
import com.phelipe.ScreenMatch.model.modelTitulo.InjectJsonModel;
import com.phelipe.ScreenMatch.repository.RepositoryMedia;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

@Service
public class GetTituloJsonOmdb {

    private final RepositoryMedia repositoryMedia;
    private final ObjectMapper mapper = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE);

    public GetTituloJsonOmdb(RepositoryMedia repositoryMedia) {
        this.repositoryMedia = repositoryMedia;
    }

    public EntityMedia addTitulos() {
        try {
            HttpClient httpClient = HttpClient.newHttpClient();

            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create("http://www.omdbapi.com/?t=Batman&apikey=a244a81e"))
                    .build();

            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            InjectJsonModel injectJsonModel = mapper.readValue(httpResponse.body(),InjectJsonModel.class);

            EntityMedia entityMedia = injectJsonModel.injection();

            return repositoryMedia.save(entityMedia);

        } catch (ExceptionGetTituloJsonOmdb | IOException | InterruptedException e) {
            throw new ExceptionGetTituloJsonOmdb();
        }
    }
}
