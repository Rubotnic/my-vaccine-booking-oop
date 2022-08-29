package se.lexicon.data.collections;

import se.lexicon.data.interfaces.PatientDAO;
import se.lexicon.model.Patient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class PatientDAOIMPL implements PatientDAO {

    private List<Patient> patientlist;

    public PatientDAOIMPL() {
        patientlist = new ArrayList<>();
    }

    @Override
    public Patient create(Patient patient) {
        if (patient == null) throw new IllegalArgumentException("Patient was null, not allowed!");

        patientlist.add(patient);
        return patient;
    }

    @Override
    public List<Patient> findAll() {
        return patientlist;
    }

    @Override
    public Optional<Patient> findById(String id) {
        Optional<Patient> patient = Optional.empty();

        for (Patient pat : patientlist) {

            if (pat.getId().equals(id));
            patient = Optional.of(pat);
        }
        return patient;
    }

    @Override
    public boolean delete(String id) {
        return patientlist.remove(findById(id).orElseThrow(()-> new RuntimeException("Patient Not Found!")));
    }

    @Override
    public Collection<Patient> findPatientByBirthDateBefore(LocalDate date) {

        Collection<Patient> foundMatches = new ArrayList<>();
        for (Patient p : patientlist){
            if (p.getBirthDate().isBefore(date) || p.getBirthDate().equals(date)); {
                foundMatches.add(p);
            }
        }
        return foundMatches;
    }
}
