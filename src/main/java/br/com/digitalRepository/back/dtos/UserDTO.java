
package br.com.digitalRepository.back.dtos;

public class UserDTO {

    private String Username;
    private String Password;

    public UserDTO()
    {
        this.Username = "";
        this.Password = "";
    }
    public UserDTO(String Username, String Password)
    {
        this.Username = Username;
        this.Password = Password;
    }
    
    public void setPassword(String Password)
    {
        this.Password = Password;
    }
    
    public String getPassword()
    {
        return this.Password;
    }

    public String getUsername()
    {
        return this.Username;
    }
    public void setUsername(String Username)
    {
        this.Username = Username;
    }

}
