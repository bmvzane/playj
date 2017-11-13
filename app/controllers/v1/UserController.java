package controllers.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import org.joda.time.DateTime;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.inject.Inject;

import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Result;
import repositories.IUsersRepository;

public class UserController extends AbstractController
{
    private final HttpExecutionContext httpExecutionContext;
    
    private final IUsersRepository usersRepository;

    @Inject
    public UserController(
            HttpExecutionContext httpExecutionContext,
            IUsersRepository usersRepository
    ) {
        this.httpExecutionContext = httpExecutionContext;
        this.usersRepository      = usersRepository;
    }
    
    public Result getUsers() throws JsonProcessingException
    {
//        List<User> users = new ArrayList<User>();
//        
//        for (long i=0; i<10; i++) {
//            User user = new User();
//            user.id = i;
//            user.email = "test_" + i + "@example.com";
//            user.firstName = "TestF" + i;
//            user.lastName = "TestL" + i;
//            user.test = new DateTime();
//            
//            users.add(user);
//        }
        
        return ok(Json.toJson(this.usersRepository.getUsers()));
    }
    
    public CompletionStage<Result> postUser() throws JsonProcessingException
    {
        return CompletableFuture.supplyAsync(() -> {
            return this.usersRepository.createUser();
        })
        .thenApply(user -> {
            return created(Json.toJson(user));
        });
    }
    
}
