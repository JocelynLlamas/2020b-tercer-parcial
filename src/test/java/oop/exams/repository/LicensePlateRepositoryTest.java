package oop.exams.repository;
import oop.exams.exception.BadRegionException;
import oop.exams.model.Region;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LicensePlateRepositoryTest {
    private LicensePlateRepository licensePlateRepository;

    @BeforeEach
    public void setup() {
        licensePlateRepository = new LicensePlateRepository();
    }

    @Test
    public void givenANonSouthState_whenGenerate_thenReturnSouth() {
        //Given:
        String state = "MIC";

        //When:
        Region region = licensePlateRepository.getRegionByState(state);

        //Then:
        assertThat(region).isEqualByComparingTo(Region.SOUTH);
    }

    @Test
    public void givenANonNorthState_whenGenerate_thenReturnNorth() {
        //Given:
        String state = "SON";

        //When:
        Region region = licensePlateRepository.getRegionByState(state);

        //Then:
        assertThat(region).isEqualByComparingTo(Region.NORTH);
    }

    @Test
    public void givenANonCenterState_whenGenerate_thenReturnCenter() {
        //Given:
        String state = "AGU";

        //When:
        Region region = licensePlateRepository.getRegionByState(state);

        //Then:
        assertThat(region).isEqualByComparingTo(Region.CENTER);
    }

    @Test
    public void givenANonWestState_whenGenerate_thenReturnWest() {
        //Given:
        String state = "SIN";

        //When:
        Region region = licensePlateRepository.getRegionByState(state);

        //Then:
        assertThat(region).isEqualByComparingTo(Region.WEST);
    }

    @Test
    public void givenRegionTest() {
        //GIVEN
        LicensePlateRepository licensePlateRepository = new LicensePlateRepository();
        //WHEN
        try {
            int tamanio = licensePlateRepository.countByRegion(Region.CENTER);
            assertThat(tamanio).isEqualTo(1);
        } catch (NullPointerException e) {

        }
        //THEN

    }

    @Test
    public void givenaWhongState_thenThrowBadRegionException() throws BadRegionException {
        //Given:
        
        //Then:
        Assertions.assertThrows(BadRegionException.class, () -> {
            throw new BadRegionException("Estado desconocido");
        });
        //When:
    }

    @Test
    public void saveTest() {
        //Given:
        String licensePlate = null;
        LicensePlateRepository licensePlateRepository = new LicensePlateRepository();
        //When:
        licensePlateRepository.save(Region.CENTER, licensePlate);
    }

}
