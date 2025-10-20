package requestJson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CriarUsuario {

    public String email;
    public String password;
    public String birthday;
    public String name;
    public Boolean provider;
    public String specialty;

    private static final String[] FIRST_NAMES = {
            "Lucas", "Ana", "Marcos", "Beatriz", "Felipe", "Camila",
            "Rafael", "Larissa", "Gustavo", "Fernanda", "Bruno", "Juliana"
    };

    private static final String[] LAST_NAMES = {
            "Silva", "Souza", "Oliveira", "Costa", "Pereira", "Rodrigues",
            "Almeida", "Nascimento", "Araujo", "Fernandes", "Carvalho"
    };

    private static final String[] SPECIALTIES = {
            "Fisioterapia", "Nutrição", "Psicologia", "Odontologia", "Dermatologia",
            "Personal Trainer", "Oftalmologia", "Endocrinologia", "Pilates", "Estética"
    };

    public CriarUsuario() {
        Random random = new Random();

        // Nome completo
        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        this.name = firstName + " " + lastName;

        // E-mail baseado no nome
        String domain = "@testmail.com";
        this.email = (firstName + "." + lastName + random.nextInt(1000) + domain)
                .toLowerCase()
                .replace(" ", "");

        // Senha válida
        this.password = generateValidPassword();

        // Data de nascimento (entre 18 e 50 anos)
        this.birthday = generateValidBirthday();

        // Provider
        this.provider = true;

        // Especialidade apenas se for provider
        this.specialty = SPECIALTIES[random.nextInt(SPECIALTIES.length)];
    }

    private String generateValidPassword() {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String symbols = "!@#$%";
        String all = upper + lower + digits + symbols;
        Random random = new Random();

        StringBuilder sb = new StringBuilder();
        sb.append(upper.charAt(random.nextInt(upper.length())));
        sb.append(lower.charAt(random.nextInt(lower.length())));
        sb.append(digits.charAt(random.nextInt(digits.length())));
        sb.append(symbols.charAt(random.nextInt(symbols.length())));

        while (sb.length() < 10) {
            sb.append(all.charAt(random.nextInt(all.length())));
        }

        return sb.toString();
    }

    private String generateValidBirthday() {
        LocalDate now = LocalDate.now();
        LocalDate startDate = now.minusYears(50);
        LocalDate endDate = now.minusYears(18);

        long start = startDate.toEpochDay();
        long end = endDate.toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(start, end);

        return LocalDate.ofEpochDay(randomDay).toString(); // formato ISO yyyy-MM-dd
    }

    /**
     * Converte o objeto CriarUsuario para JSON pronto para enviar na API.
     */
    public String toJson() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao converter CriarUsuario para JSON", e);
        }
    }
}