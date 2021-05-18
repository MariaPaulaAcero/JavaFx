package sample.logic.persistence;

import sample.logic.entities.Exportable;
import java.util.List;

public interface IExport {

    void export(List<Exportable> exportable, Character separateValue) throws Exception;
}