package principal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.util.Date;

/**
 * Classe que simboliza a passagem aérea
 */
public class Trip implements Serializable {
    /**
     * Váriavel para viagem ser de ida(false), ida e volta(true)
     */
    private boolean roundTrip;
    /**
     * Origem da passagem
     */
    private String source;
    /**
     * Destino da passagem
     */
    private String destination;
    /**
     * Data de ida da viagem
     */
    private Date begin;
    /**
     * Data de volta da viagem
     */
    private Date end;
    /**
     * Numero de passagens
     */
    private Integer numberOfAirfares;

    /**
     * Retorna true caso a viagem seja de ida e volta, false caso só ida
     * @return true caso a viagem seja de ida e volta, false caso só ida
     */
    public boolean isRoundTrip() {
        return roundTrip;
    }

    /**
     * Define se a viagem é só de ida ou de ida e volta
     * @param roundTrip true caso a viagem seja de ida e volta, false caso só ida
     */
    public void setRoundTrip(boolean roundTrip) {
        this.roundTrip = roundTrip;
    }

    /**
     * Retorna
     * @return
     */
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Integer getNumberOfAirfares() {
        return numberOfAirfares;
    }

    public void setNumberOfAirfares(Integer numberOfAirfares) {
        this.numberOfAirfares = numberOfAirfares;
    }

}
