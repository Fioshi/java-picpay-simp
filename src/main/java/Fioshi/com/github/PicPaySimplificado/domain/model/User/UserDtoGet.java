package Fioshi.com.github.PicPaySimplificado.domain.model.User;

public record UserDtoGet(

        String name,

        String surname
) {
    public UserDtoGet(User user){
        this(user.getName(), user.getSurname());
    }
}
