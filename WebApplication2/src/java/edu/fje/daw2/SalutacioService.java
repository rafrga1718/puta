package edu.fje.daw2;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


/**
 * REST Web Service
 *
 * @author sergi grau (sergi.grau@fje.edu)
 * @version 1.0 10.04.2014
 */

@Path("servei")

public class SalutacioService {
    ArrayList<Partida> partidas = new ArrayList();
    // cridat si es demana TEXT_PLAIN
    @GET
    @Path("/hola")
    @Produces (MediaType.APPLICATION_XML)
    public List <Partida> getPartidas(){
            Partida p1 =new Partida();
            p1.setId(1);
            p1.startLoses(0);
            p1.startWins(0);
            partidas.add(p1);
    return partidas;
    }

    @DELETE
    @Path("/acabarJoc")
    @Produces (MediaType.APPLICATION_XML)
    public List <Partida> deletePartida(@QueryParam("num") int n){
        for (int i=0;i<partidas.size(); i++){
        Partida p= partidas.get(i);
        if (p.getId()==n){
            partidas.remove(i);
        }   
    }
        return partidas;
    }
    @PUT
    @Path("/move")
    @Produces(MediaType.TEXT_PLAIN)
    public List<Partida> putPuntuacion(@QueryParam("move")String move, @QueryParam("partida") int p) {
        String[] jugadaIa={"stone","paper", "scissors"};
        int random= (int) Math.floor(Math.random()*(2+1));
        String resIA=jugadaIa[random];
        Partida partida = partidas.get(p);
        if(partida.getWins()==3){
            out.println("you win");
        }
        else if(partida.getLoses()==3){
             out.println("you lose");
        }
        else{
            if(move==resIA){
                out.println("tie");
            }
            else if(move.equals("stone")&& resIA.equals("paper")){
            partida.setLoses();
        }
            else if(move.equals("stone")&& resIA.equals("scissors")){
            partida.setWins();
        }
               else if(move.equals("stone")&& resIA.equals("stone")){
        }
               else if(move.equals("paper")&& resIA.equals("paper")){
            partida.setLoses();
        }
               else if(move.equals("paper")&& resIA.equals("scissors")){
            partida.setLoses();
        }
               else if(move.equals("paper")&& resIA.equals("stone")){
            partida.setWins();
        }
               else if(move.equals("scissors")&& resIA.equals("paper")){
            partida.setWins();
        }
               else if(move.equals("scissors")&& resIA.equals("stone")){
            partida.setLoses();
        }
                else if(move.equals("scissors")&& resIA.equals("scissors")){
        }   
            
        }
        return partidas;
    }

    @POST
    @Path("/afegirPartida")
    @Consumes(MediaType.TEXT_PLAIN)
    public List<Partida> postPartida() {
        Partida p1 =new Partida();
        int id = partidas.size()+1;
            p1.setId(id);
            p1.startLoses(0);
            p1.startWins(0);
            partidas.add(p1);
            return partidas;
    }

}
