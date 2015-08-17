package bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

public class MapBean 
{
	private MapModel simpleModel;
	private MapModel draggableModel;
	
	private double lat = 9.9157834;
	private double lng = -84.0700541;

	private Marker marker;

	@PostConstruct
	public void init() {
		simpleModel = new DefaultMapModel();
		draggableModel = new DefaultMapModel();

		//Shared coordinates
		LatLng coord1 = new LatLng(lat, lng);

		LatLng coord2 = new LatLng(lat, lng);


		//Basic marker
		simpleModel.addOverlay(new Marker(coord1, "Konyaalti"));

		draggableModel.addOverlay(new Marker(coord2, "Ataturk Parki"));

		for(Marker premarker : draggableModel.getMarkers()) {
			premarker.setDraggable(true);
		}
	}

	public MapModel getSimpleModel() {
		return simpleModel;
	}

	public void onMarkerSelect(OverlaySelectEvent event) {
		marker = (Marker) event.getOverlay();

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Selected", marker.getTitle()));
	}

	public Marker getMarker() {
		return marker;
	}

	public MapModel getDraggableModel() {
		return draggableModel;
	}

	public void onMarkerDrag(MarkerDragEvent event) {
		marker = event.getMarker();

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Dragged", "Lat:" + marker.getLatlng().getLat() + ", Lng:" + marker.getLatlng().getLng()));
		setLat(marker.getLatlng().getLat());
		setLng(marker.getLatlng().getLng());
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}
}
