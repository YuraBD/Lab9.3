package builder;

public class Main {
    public static void main(String[] args) {
        User user = User.builder()
                .firstName("Yura")
                .age(18)
                .occupation("UCU")
                .occupation("UCU")
                .lastName("Bodakovskyi")
                .gender("male")
                .build();
        System.out.println(user);
    }
}
