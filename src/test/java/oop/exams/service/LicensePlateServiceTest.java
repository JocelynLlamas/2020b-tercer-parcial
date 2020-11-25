package oop.exams.service;

import oop.exams.exception.NotAvailableLicensePlateException;
import oop.exams.generator.LicensePlateGenerator;
import oop.exams.generator.LicensePlateGeneratorFactory;
import oop.exams.model.Region;
import oop.exams.repository.LicensePlateRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LicensePlateServiceTest {

    @Test
    public void givenAValidState_whenGenerate_thenLicensePlateIsReturned() throws NotAvailableLicensePlateException {
        // Given:
        LicensePlateGeneratorFactory factory = mock(LicensePlateGeneratorFactory.class);
        LicensePlateRepository repository = mock(LicensePlateRepository.class);
        LicensePlateGenerator generator = mock(LicensePlateGenerator.class);
        LicensePlateService licensePlateService = new LicensePlateService(factory, repository);
        String state = "SLP";
        String expectedLicensePlate = "ABC1234";

        when(repository.getRegionByState(state)).thenReturn(Region.CENTER);
        when(repository.countByRegion(Region.CENTER)).thenReturn(1);
        when(factory.getInstance(Region.CENTER)).thenReturn(generator);
        when(generator.generate(state)).thenReturn(expectedLicensePlate);

        // When:
        String licensePlate = licensePlateService.generate(state);

        // Then:
        assertThat(licensePlate).isEqualTo(expectedLicensePlate);
        verify(repository).getRegionByState(state);
        verify(repository).countByRegion(Region.CENTER);
        verify(factory).getInstance(Region.CENTER);
        verify(generator).generate(state);
        verify(repository).save(Region.CENTER, licensePlate);
        verifyNoMoreInteractions(repository, factory, generator);
    }
    
    @Test
    public void givenAState_whenGenerate_thenLicenseIsReturned() {
        // Given:
        try {
            LicensePlateService licensePlateService = new LicensePlateService(null, null);

        }  catch (Exception e) {
            e.printStackTrace();

        }  
        String state = "SLP";
        LicensePlateGeneratorFactory factory = mock(LicensePlateGeneratorFactory.class);
        LicensePlateRepository repository = mock(LicensePlateRepository.class);
        LicensePlateGenerator generator = mock(LicensePlateGenerator.class);
        String expectedLicensePlate;
        // When:
        when(repository.countByRegion(Region.CENTER)).thenReturn(1);
        when(factory.getInstance(Region.CENTER)).thenReturn(generator);
        //when(generator.generate(state)).thenReturn(expectedLicensePlate);
        when(repository.getRegionByState(state)).thenReturn(Region.CENTER);
        // Then:
        Assertions.assertThrows(NotAvailableLicensePlateException.class, () -> {
            //licensePlateService.generate(state);
        });
    }

}