package db;

import db.Otprema;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-07-20T17:42:49")
@StaticMetamodel(Radninalog.class)
public class Radninalog_ { 

    public static volatile SingularAttribute<Radninalog, Date> datum;
    public static volatile SingularAttribute<Radninalog, String> kupac;
    public static volatile SingularAttribute<Radninalog, Integer> brojotpreme;
    public static volatile CollectionAttribute<Radninalog, Otprema> otpremaCollection;
    public static volatile SingularAttribute<Radninalog, Float> ugovorenom3;
    public static volatile SingularAttribute<Radninalog, String> gradiliste;
    public static volatile SingularAttribute<Radninalog, Long> rn;
    public static volatile SingularAttribute<Radninalog, Float> isporucenom3;
    public static volatile SingularAttribute<Radninalog, String> markabetona;
    public static volatile SingularAttribute<Radninalog, Integer> status;

}