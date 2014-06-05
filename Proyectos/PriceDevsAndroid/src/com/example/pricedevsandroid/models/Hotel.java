package com.example.pricedevsandroid.models;

public class Hotel {
	/*
	 * Identificador del hotel en la lista
	 */
	private Integer id;
	
	/*
	 * Nombre del hotel
	 */
	private String name;
	
	/*
	 * Descripcion o pequeña refencia del hotel
	 */
	private String description;
	
	/*
	 * Latitud de la posicion del hotel en el mapa
	 */
	private double lat;
	
	/*
	 * Longitud de la posicion del hotel en el mapa
	 */
	private double lon;
	
	/*
	 * Ruta del logo del hotel dentro de la carpeta assets
	 */
	private String logo;
	
	/*
	 * Ruta de la imagen principal del hotel dentro de la carpeta assets
	 */
	private String mainImage;
	
	

	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * 
	 */
	public Hotel(Integer id, String name, String description, double lat,
			double lon, String logo, String mainImage) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.lat = lat;
		this.lon = lon;
		this.logo = logo;
		this.mainImage = mainImage;
	}



	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the lat
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * @param lat the lat to set
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}

	/**
	 * @return the lon
	 */
	public double getLon() {
		return lon;
	}

	/**
	 * @param lon the lon to set
	 */
	public void setLon(double lon) {
		this.lon = lon;
	}

	/**
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * @param logo the logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}

	/**
	 * @return the mainImage
	 */
	public String getMainImage() {
		return mainImage;
	}

	/**
	 * @param mainImage the mainImage to set
	 */
	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}
	
	

}
