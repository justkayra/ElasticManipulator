package com.semantyca.ess.store.model;



import com.semantyca.ess.store.BooleanAdapter;
import com.semantyca.ess.store.LocalDateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Location")
public class Location  {
    @XmlAttribute(name = "id")
    private String id;
    @XmlElement(name = "Name")
    private String name;
    @XmlElement(name = "Type")
    private String type;
    @XmlElement(name = "SubType")
    private String subType;
    private int NDSASQM;
    @XmlElement(name = "IsStore")
    @XmlJavaTypeAdapter(value = BooleanAdapter.class)
    private Boolean isStore;
    @XmlElement(name = "StoreNumber")
    private int storeNumber;
    @XmlElement(name = "Hierarchy")
    private Hierarchy hierarchyObject;
    @XmlElement(name = "Address")
    private Address addressObject;
    @XmlElement(name = "ContactDetails")
    private ContactDetails contactDetailsObject;
    @XmlElement(name = "OpenDate")
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate openDate;
    @XmlElement(name = "Status")
    private Status status;
    @XmlElement(name = "OperationalHours")
    private OperationalHours operationalHours;
    @XmlElement(name = "Currency")
    private Currency currency;
    @XmlElement(name = "CostCentre")
    private CostCentre costCentre;
    @XmlElement(name = "Format")
    private String format;
    @XmlElement(name = "Origin")
    private String origin;
    @XmlElement(name = "DeliveryChain")
    private String deliveryChain;
    @XmlElement(name = "Displayname")
    private String displayname;
    @XmlElement(name = "Services")
    private Services services;
    @XmlElement(name = "Facilities")
    private Facilities facilities;
    @XmlElement(name = "IsSpecialDummy")
    @XmlJavaTypeAdapter(value = BooleanAdapter.class)
    private Boolean isSpecialDummy;
    @XmlElement(name = "IsFranchise")
    @XmlJavaTypeAdapter(value = BooleanAdapter.class)
    private Boolean isFranchise;
    @XmlElement(name = "IsMidnightPharmacy")
    @XmlJavaTypeAdapter(value = BooleanAdapter.class)
    private Boolean isMidnightPharmacy;
    private NHSContract NHSContract;
    private String NHSMarket;
    @XmlElement(name = "IsPharmacy")
    @XmlJavaTypeAdapter(value = BooleanAdapter.class)
    private Boolean isPharmacy;
    private PMAClassification PMAClassification;
    @XmlElement(name = "PriceBand")
    private PriceBand priceBand;
    @XmlElement(name = "PrimaryCareOrganisation")
    private String primaryCareOrganisation;
    @XmlElement(name = "VanRoutes")
    private VanRoutes vanRoutes;
    @XmlElement(name = "Manager")
    private Manager manager;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public int getNDSASQM() {
        return NDSASQM;
    }

    public void setNDSASQM(int NDSASQM) {
        this.NDSASQM = NDSASQM;
    }

    public Boolean getIsStore() {
        return isStore;
    }

    public void setIsStore(Boolean isStore) {
        this.isStore = isStore;
    }

    public int getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(int storeNumber) {
        this.storeNumber = storeNumber;
    }

    public Hierarchy getHierarchyObject() {
        return hierarchyObject;
    }

    public void setHierarchyObject(Hierarchy hierarchyObject) {
        this.hierarchyObject = hierarchyObject;
    }

    public Address getAddressObject() {
        return addressObject;
    }

    public void setAddressObject(Address addressObject) {
        this.addressObject = addressObject;
    }

    public ContactDetails getContactDetailsObject() {
        return contactDetailsObject;
    }

    public void setContactDetailsObject(ContactDetails contactDetailsObject) {
        this.contactDetailsObject = contactDetailsObject;
    }

    public LocalDate getOpenDate() {
        return openDate;
    }

    public void setOpenDate(LocalDate openDate) {
        this.openDate = openDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

  /*  public ArrayList<DayOfWeek> getOperationalHours() {
        return operationalHours;
    }

    public void setOperationalHours(ArrayList<DayOfWeek> operationalHours) {
        this.operationalHours = operationalHours;
    }*/

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public CostCentre getCostCentre() {
        return costCentre;
    }

    public void setCostCentre(CostCentre costCentre) {
        this.costCentre = costCentre;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDeliveryChain() {
        return deliveryChain;
    }

    public void setDeliveryChain(String deliveryChain) {
        this.deliveryChain = deliveryChain;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

  /*  public List<Facility> getDayOfWeeks() {
        return facilities;
    }

    public void setDayOfWeeks(ArrayList<Facility> facilities) {
        this.facilities = facilities;
    }*/

    public Boolean isSpecialDummy() {
        return isSpecialDummy;
    }

    public void setSpecialDummy(Boolean specialDummy) {
        isSpecialDummy = specialDummy;
    }

    public Boolean isFranchise() {
        return isFranchise;
    }

    public void setFranchise(Boolean franchise) {
        isFranchise = franchise;
    }

    public Boolean isMidnightPharmacy() {
        return isMidnightPharmacy;
    }

    public void setMidnightPharmacy(Boolean midnightPharmacy) {
        isMidnightPharmacy = midnightPharmacy;
    }

    public NHSContract getNHSContract() {
        return NHSContract;
    }

    public void setNHSContract(NHSContract NHSContract) {
        this.NHSContract = NHSContract;
    }

    public String getNHSMarket() {
        return NHSMarket;
    }

    public void setNHSMarket(String NHSMarket) {
        this.NHSMarket = NHSMarket;
    }

    public Boolean isPharmacy() {
        return isPharmacy;
    }

    public void setPharmacy(Boolean pharmacy) {
        isPharmacy = pharmacy;
    }

    public PMAClassification getPMAClassification() {
        return PMAClassification;
    }

    public void setPMAClassification(PMAClassification PMAClassification) {
        this.PMAClassification = PMAClassification;
    }

    public PriceBand getPriceBand() {
        return priceBand;
    }

    public void setPriceBand(PriceBand priceBand) {
        this.priceBand = priceBand;
    }

    public String getPrimaryCareOrganisation() {
        return primaryCareOrganisation;
    }

    public void setPrimaryCareOrganisation(String primaryCareOrganisation) {
        this.primaryCareOrganisation = primaryCareOrganisation;
    }

    public VanRoutes getVanRoutes() {
        return vanRoutes;
    }

    public void setVanRoutes(VanRoutes vanRoutes) {
        this.vanRoutes = vanRoutes;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Facilities getFacilities() {
        return facilities;
    }

    public void setFacilities(Facilities facilities) {
        this.facilities = facilities;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getStore() {
        return isStore;
    }

    public void setStore(Boolean store) {
        isStore = store;
    }

    public Boolean getSpecialDummy() {
        return isSpecialDummy;
    }

    public Boolean getFranchise() {
        return isFranchise;
    }

    public Boolean getMidnightPharmacy() {
        return isMidnightPharmacy;
    }

    public Boolean getPharmacy() {
        return isPharmacy;
    }

    public OperationalHours getOperationalHours() {
        return operationalHours;
    }

    public void setOperationalHours(OperationalHours operationalHours) {
        this.operationalHours = operationalHours;
    }

    @Override
    public String toString() {
        return "Location{" + getId() + ", name=" + name + "}";
    }


}