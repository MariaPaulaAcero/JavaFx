package sample.logic.services;

import sample.logic.entities.Persona;
import sample.logic.entities.Report;

import java.util.List;
import java.util.Map;

public interface IReportServices {
    Map<String, Report> getReportPersonasByProfession();
    Map<String, Report> getReportPersonasByProfession(List<Persona> personas);

    Report getCountOfVictims();

}
