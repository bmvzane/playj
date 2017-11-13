package repositories;

import java.util.List;

import repositories.models.User;

public interface IUsersRepository
{
    
    public List<User> getUsers();
    
    public User getUserById(long id);
    
    public User createUser();
    
    public Boolean updateUser();
    
    public Boolean deleteUser();
    
}
