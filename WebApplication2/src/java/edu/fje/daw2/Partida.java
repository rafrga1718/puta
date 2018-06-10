package edu.fje.daw2;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Raúl
 */
@XmlRootElement
public class Partida {
    private int id;
    private int wins;
    private int loses;
    public Partida(int id, int wins, int loses) { 
        this.id=id;
        this.wins=wins;
        this.loses=loses;
    }
    public Partida(){
    
    }

    public int getId() {
        return id;
    }

    public int getWins() {
        return wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWins() {
        this.wins++;
    }

    public void setLoses() {
        this.loses++;
    }
    public void startWins(int wins){
        this.wins=wins;
    }
    public void startLoses(int wins){
        this.loses=wins;
    }
    
}
