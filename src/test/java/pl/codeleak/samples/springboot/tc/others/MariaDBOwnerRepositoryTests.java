package pl.codeleak.samples.springboot.tc.others;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import pl.codeleak.samples.springboot.tc.OwnerRepository;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("mariadb")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MariaDBOwnerRepositoryTests {

    @Autowired
    private OwnerRepository ownerRepository;

    @Test
    void findAllReturnsZeroRecords() {
        var owners = ownerRepository.findAll();
        assertThat(owners.size()).isZero();
    }
}
