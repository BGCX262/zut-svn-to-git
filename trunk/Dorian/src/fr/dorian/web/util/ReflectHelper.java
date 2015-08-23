package fr.dorian.web.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;


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

public class ReflectHelper
{
    
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<Object, Collection> reflectMap(Collection collection2map, String strProperty)
    {	
    	//Map mapElt                                        = new TreeMap();
        Map mapElt                                          = new HashMap();
        
        try
        {   
            for (Iterator iteratorElt = collection2map.iterator(); iteratorElt.hasNext(); )
            {
                try
                {
                    Object elt                              = iteratorElt.next();     
                    Object keyValue                         = PropertyUtils.getProperty(elt, strProperty);
                    Collection collectionEntry              = (Collection) mapElt.get(keyValue);    

                    if (collectionEntry == null)
                    {
                        collectionEntry                     = new ArrayList(); 

                        collectionEntry.add(elt);   

                        mapElt.put(keyValue, collectionEntry);
                    }

                    else
                        collectionEntry.add(elt);
                }
                catch (Exception e) {System.out.println("ReflectHelper: reflectMap: " + e.toString());}
            }   
        }
        catch (Exception e) {System.out.println("ReflectHelper: reflectMap: " + e.toString());}

        return mapElt;          
    }

}
