package sample.logic.services.impl;

import sample.logic.entities.Persona;
import sample.logic.entities.ProfessionEnum;
import sample.logic.entities.Report;
import sample.logic.services.IPersonaServices;
import sample.logic.services.IReportServices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportServices implements IReportServices {

    private IPersonaServices personaServices;

    public ReportServices() {
        personaServices = new PersonaService();
    }

    public Map<String, Report> getReportPersonasByProfession() {

        List<Persona> personas = personaServices.getAll();
        return this.getReportPersonasByProfession();//habia puesto personas
    }

    public Map<String, Report> getReportPersonasByProfession(List<Persona> personas) {

        Map<String, Report> reports = new HashMap();

        for (ProfessionEnum profession : ProfessionEnum.values()) {
            reports.put(profession.toString(), new Report(profession.toString(), 0, String.format("Report of count of personas in profession %s", profession.toString())));
        }

        for (Persona p : personas) {
            reports.get(p.getProfession().toString()).incrementCount();
        }


        return reports;

    }

    public Report getCountOfVictims() {

        List<Persona> personas = personaServices.getAll();
        int numOfVictims = (int) personas.stream().filter(p -> p.isVictim()).count();

        return new Report("Victims", numOfVictims, "This is the number of victims during the strikes");
    }

}