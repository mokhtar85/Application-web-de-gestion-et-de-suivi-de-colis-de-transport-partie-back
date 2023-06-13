package tn.applicationtrack.applicationpfe.requests;

import java.time.LocalDateTime;

import tn.applicationtrack.applicationpfe.entities.Admin;
import tn.applicationtrack.applicationpfe.entities.Transporteur;

public class NotificationRequest {
	  private Long id;

	    private String contenu;
	    int count;

	    private LocalDateTime heureEnvoi;

	    private boolean estLue;
	    private Admin admin;
	    private Transporteur transporteur;

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

		public NotificationRequest(Long id, String contenu, int count, LocalDateTime heureEnvoi, boolean estLue) {
			super();
			this.id = id;
			this.contenu = contenu;
			this.count = count;
			this.heureEnvoi = heureEnvoi;
			this.estLue = estLue;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getContenu() {
			return contenu;
		}

		public void setContenu(String contenu) {
			this.contenu = contenu;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
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
		
}
