package at.jsfpractice.jsf22.example02;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Named
@ManagedBean
@ViewScoped

public class PersonPage {
//    @Inject
	@ManagedProperty("#{personRepository}")
    private PersonRepository personRepository;
    private int selectedId;
    private Person selectedPerson;
    
	private List<HashMap> dataList;
    
    public PersonPage()
    {
    	dataList = new ArrayList();
    	
    	for (int i = 0; i < 2; i++)
    	{
    		HashMap<String, Object> dataMap = new HashMap<String, Object>();
    		dataMap.put("value", "radio"+i);
    		dataList.add(dataMap);
    	}
    	
    	personRepository = new PersonRepository();
    	personRepository.init();
    }
    
    public List<HashMap> getDataList() 
    {
        return dataList;
    }

    public Collection<Person> getPersons() 
    {
    	System.err.println("personRepository=="+ (personRepository == null));
        return personRepository.getPersons();
    }

    public void loadPerson() 
    {
        selectedPerson = personRepository.getPerson(selectedId);
    }

    public Person getSelectedPerson() 
    {
        return selectedPerson;
    }

    public void setSelectedId(int selectedId) 
    {
        this.selectedId = selectedId;
    }

    public int getSelectedId() 
    {
        return selectedId;
    }

    public void setPersonRepository(PersonRepository personRepository) 
    {
        this.personRepository = personRepository;
    }
    
    public void test()
    {
    	System.err.println("getPersons====");
    }
}
