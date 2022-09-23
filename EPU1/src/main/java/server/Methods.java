package server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Methods {
    //DaoPerson daoPerson = new DaoPerson();

    public String generateCurp(String name, String lastname, String surname, String genre, String state, String birthday) {
        String curp = lastname.substring(0, 2) + surname.charAt(0) + name.charAt(0) + birthday.substring(8, 10) +
                birthday.substring(3, 5) + birthday.substring(0, 2);
        return curp.toUpperCase();
    }

    public String searchPerson(String curp) {
        List<BeanPerson> people = new ArrayList<>();
        //Iterator it = people.iterator();
        int findPerson = people.indexOf(curp);

        /*if (findPerson >= 0){
            return people.get(findPerson).toString();
        }else {
            return "Persona no encontrada";
        }*/

        do {
            //if (it.hasNext()) {
            for (int i = 0; i < people.size(); i++) {
                if (people.get(i).getCurp().equalsIgnoreCase(curp)) {
                    findPerson = i;
                    break;
                }
            }
            //}
        } while (findPerson == -1);
        return people.get(findPerson).toString();
    }
}
