package repositories.fake;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import repositories.IUsersRepository;
import repositories.models.User;

public class UsersRepository implements IUsersRepository
{
    
    private static final List<User> usersCollection = new ArrayList<User>();
    private static Long sequentialId = 0L;
    
    public UsersRepository()
    {
        if (usersCollection.isEmpty()) {
            for (long i=1; i<=10; i++) {
                User user = new User();
                user.id = i;
                user.email = "test_" + i + "@example.com";
                user.firstName = "TestFirstName_" + i;
                user.lastName = "TestLastName_" + i;
                user.createdAt = LocalDateTime.of(2017, (int) i, (int) i, 12, 30, 0);
                
                usersCollection.add(user);
                
                sequentialId++;
            }
        }
    }
    
    public List<User> getUsers()
    {
        return usersCollection;
    }
    
    public User getUserById(long id)
    {
        return usersCollection.stream()
                              .filter(x -> x.id == id)
                              .findFirst()
                              .orElse(null);
    }
    
    public User createUser()
    {
        long i = sequentialId;
        
        User user = new User();
        user.id = i;
        user.email = "test_" + i + "@example.com";
        user.firstName = "TestFirstName_" + i;
        user.lastName = "TestLastName_" + i;
        user.createdAt = LocalDateTime.now();
        
        usersCollection.add(user);
        
        sequentialId++;
        
        return user;
    }
    
    public Boolean updateUser()
    {
        return true;
    }
    
    public Boolean deleteUser()
    {
        return true;
    }
    
}
