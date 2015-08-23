package fr.dorian.web.util;

import org.apache.commons.collections.Predicate;
import org.apache.commons.lang.StringUtils;

/** @author Dimitri Dean DARSEYNE (D3), 
 * published by Short-Circuit under Creative Commons (CC) Licensing: 
 * Authorship/Paternity, NO Commercial Use, NO Derivative
 * please check for more informations:
 * http://creativecommons.org/licenses/by-nc-nd/2.0/
 *
 * auteur Dimitri Dean DARSEYNE (D3),
 * publié par Short-Circuit sous license Creative Commons (CC):
 * Paternité, PAS d'Utilisation Commerciale, pas de Dérivés/Modifications
 * Pour plus d'informations, se rendre sur:
 * http://creativecommons.org/licenses/by-nc-nd/2.0/fr/ 
 * 
 * @since Short-Circuit 1999
 */

/**
* Composite Predicate to check positive String.indexOf rule !!!
*/
public class StartsWithPredicate implements Predicate
{
    private String value;
   

    public StartsWithPredicate(String value)       
    {
        setValue(value);
    }
   
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Predicate interface implementation
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean evaluate(Object target) //throws ClassCastException, NullPointerException, Exception
    {
        return ((target instanceof String) && (StringUtils.isNotEmpty((String) target)))?
                    ((String) target).startsWith(value) : false;
        		//((String) target).indexOf(value) >= 0 : false;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Getters & Setters
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public String getValue()                         {return value;}
   
    public void setValue(String value)             {this.value     = value;}
}