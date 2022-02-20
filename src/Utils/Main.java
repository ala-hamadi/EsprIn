package Utils;


import Modules.Event;
import Services.EventServices;

import java.sql.Timestamp;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Event event= new Event("mmmm", " ghjkk","", "", 10020855,State.Active);
        //EventServices services=EventServices.getInstance();
        //services.add(event);
        //event.setDescription("test update 2");
        //services.update(event);
        //services.delete(event);
        //services.changeState(event, State.valueOf("Disabled"));
        //System.out.println(services.getList());
        //System.out.println(event);

        //System.out.println("\n "+services.retrive("2505213"));
        //Participate participate= new Participate(15542230 , 2505213);

        EventServices eventServices=EventServices.getInstance();
        Timestamp timestamp=new Timestamp(2022,10,30,5,6,0,0);
        Event event=new Event("Hackathon","Hackathon dev mobile", null, timestamp, 10000000);
        List<Event> events=eventServices.getList();
        System.out.println(events);
        eventServices.delete(events.get(2));
        System.out.println(events);


       /* ParticipateServices servicesparticipate = ParticipateServices.getInstance();
        EventServices eventServices=EventServices.getInstance();
        eventServices.add(event);
        List<Event> events=eventServices.getList();
        servicesparticipate.Participate(new Student(10020855, "bairem.khedhri@esprit.tn", "",
                "", Roles.Etudiant, "Bairem", "Khedhri", null, Domaine.Informatique),events.get(0));
        System.out.println(servicesparticipate.getList());*/

    }
}
