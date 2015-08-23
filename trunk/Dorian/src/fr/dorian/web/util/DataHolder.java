package fr.dorian.web.util;

import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
public class DataHolder
{
	private String 	description;
	private int 	version;
	private Date	dateCreation;
	
	private URL		dataURL;
	private File	dataFile;
	
	private Map		dataMap;
	private List	dataList;
	private Set		dataSet;

	private	Class	targetClass;
	
	
	
	public DataHolder()		{}

	public DataHolder(String description, int version)
	{
		setDescription(description);
		setVersion(version);
		
		setDateCreation(new Date());
	}
	
	public String getDescription()						{return description;}
	public int getVersion()								{return version;}
	public Date getDateCreation()						{return dateCreation;}
	public URL getDataURL()								{return dataURL;}
	public File getDataFile()							{return dataFile;}
	public Map getDataMap()								{return dataMap;}
	public List getDataList()							{return dataList;}
	public Set getDataSet()								{return dataSet;}
	public Class getTargetClass()						{return targetClass;}

	public void setDescription(String description)		{this.description 		= description;}
	public void setVersion(int version)					{this.version 			= version;}
	public void setDateCreation(Date dateCreation)		{this.dateCreation 		= dateCreation;}
	public void setDataURL(URL dataURL)					{this.dataURL 			= dataURL;}
	public void setDataFile(File dataFile)				{this.dataFile 			= dataFile;}
	public void setDataMap(Map dataMap)					{this.dataMap 			= dataMap;}
	public void setDataList(List dataList)				{this.dataList 			= dataList;}
	public void setDataSet(Set dataSet)					{this.dataSet 			= dataSet;}
	public void setTargetClass(Class targetClass)		{this.targetClass 		= targetClass;}

}
