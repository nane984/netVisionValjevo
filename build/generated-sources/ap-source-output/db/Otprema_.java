package db;

import db.Radninalog;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-07-20T17:42:49")
@StaticMetamodel(Otprema.class)
public class Otprema_ { 

    public static volatile SingularAttribute<Otprema, Date> datum;
    public static volatile SingularAttribute<Otprema, String> vozac;
    public static volatile SingularAttribute<Otprema, Float> zadatom3;
    public static volatile SingularAttribute<Otprema, Float> izdatom3;
    public static volatile SingularAttribute<Otprema, String> vozilo;
    public static volatile SingularAttribute<Otprema, Long> id;
    public static volatile SingularAttribute<Otprema, Long> brotpreme;
    public static volatile SingularAttribute<Otprema, Integer> status;
    public static volatile SingularAttribute<Otprema, Radninalog> radninalog;

}