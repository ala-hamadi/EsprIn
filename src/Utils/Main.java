package Utils;


import Modules.Event;
import Services.EventServices;
import Services.ParticipateServices;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {

        EventServices eventServices=EventServices.getInstance();
       // Timestamp timestamp=new Timestamp(2022,10,30,5,6,0,0);
        System.out.println(Date.valueOf("2022-10-30"));
        Event event=new Event("Hackathon","Hackathon dev mobile", null, Date.valueOf("2022-10-30"), 10000000);
        eventServices.add(event);
        /*List<Event> events=eventServices.getList();
        System.out.println(events);
        //services.changeState(event, State.valueOf("Disabled"));
        eventServices.delete(events.get(2));
        System.out.println(events);*/


        ParticipateServices servicesparticipate = ParticipateServices.getInstance();
        /*EventServices eventServices=EventServices.getInstance();
        eventServices.add(event);
        List<Event> events=eventServices.getList();
        servicesparticipate.Participate(new Student(10020855, "bairem.khedhri@esprit.tn", "",
                "", Roles.Etudiant, "Bairem", "Khedhri", null, Domaine.Informatique),events.get(0));
        System.out.println(servicesparticipate.getList());*/
       // UserServices userServices=UserServices.getInstance();
      //  System.out.println(userServices.sortById());

        System.out.println(eventServices.searchEventByOrganizerName("Orenda"));
        System.out.println(servicesparticipate.filterParticipateByEventId(1));
    }
}
