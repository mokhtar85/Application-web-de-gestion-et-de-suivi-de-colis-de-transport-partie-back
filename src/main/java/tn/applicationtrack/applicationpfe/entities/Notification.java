package tn.applicationtrack.applicationpfe.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
public class Notification {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String contenu;
	    private String contenuClient;
	    int count;

	    private boolean isNew;

		private LocalDateTime heureEnvoi;

	    private boolean estLue;
	    @ManyToOne
	    private Admin admin;
	    @ManyToOne
	    private Transporteur transporteur;
	    public Client getClient() {
			return client;
		}

		public void setClient(Client client) {
			this.client = client;
		}
		@ManyToOne
		@JsonIgnore
		private Client client;
		public Notification() {
			super();
			// TODO Auto-generated constructor stub
		}

		public int getCount() {
			return count;
		}
		  public void increment() {
		        this.count++;
		    }

		public void setCount(int count) {
			this.count = count;
		}

		public Notification(String contenu, LocalDateTime heureEnvoi, boolean estLue,int count) {
			super();
			this.contenu = contenu;
			this.heureEnvoi = heureEnvoi;
			this.estLue = estLue;
		}
		   public Long getId() {
				return id;
			}

			public void setId(Long id) {
				this.id = id;
			}

			public Admin getAdmin() {
				return admin;
			}

			public void setAdmin(Admin admin) {
				this.admin = admin;
			}

			public Transporteur getTransporteur() {
				return transporteur;
			}

			public void setTransporteur(Transporteur transporteur) {
				this.transporteur = transporteur;
			}

		public String getContenu() {
			return contenu;
		}

		public void setContenu(String contenu) {
			this.contenu = contenu;
		}

		public LocalDateTime getHeureEnvoi() {
			return heureEnvoi;
		}

		public void setHeureEnvoi(LocalDateTime heureEnvoi) {
			this.heureEnvoi = heureEnvoi;
		}

		public boolean isEstLue() {
			return estLue;
		}

		public void setEstLue(boolean estLue) {
			this.estLue = estLue;
		}

		public boolean isNew() {
			return isNew;
		}

		public void setNew(boolean isNew) {
			this.isNew = isNew;
		}
		   public String toJson() throws JsonProcessingException {
		        ObjectMapper objectMapper = new ObjectMapper();
		        return objectMapper.writeValueAsString(this);
		    }

		public String getContenuClient() {
			return contenuClient;
		}

		public void setContenuClient(String contenuClient) {
			this.contenuClient = contenuClient;
		}
	    
}
