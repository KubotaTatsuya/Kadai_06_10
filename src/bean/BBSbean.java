package bean;

public class BBSbean {
		private String id;
		private String mail;
		private String name;
		private String comment;
		private String file;
		private String postdate;
		private String posttime;
		private String editdatr;
		private String edittime;


		public BBSbean(String id, String mail, String name, String comment, String file, String postdate,
				String posttime, String editdatr, String edittime) {
			super();
			this.id = id;
			this.mail = mail;
			this.name = name;
			this.comment = comment;
			this.file = file;
			this.postdate = postdate;
			this.posttime = posttime;
			this.editdatr = editdatr;
			this.edittime = edittime;
		}


		public BBSbean(String mail, String name, String comment) {
			super();
			this.mail = mail;
			this.name = name;
			this.comment = comment;
		}


		public BBSbean(String mail, String name, String comment, String file) {
			super();
			this.mail = mail;
			this.name = name;
			this.comment = comment;
			this.file = file;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getMail() {
			return mail;
		}

		public void setMail(String mail) {
			this.mail = mail;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		public String getFile() {
			return file;
		}

		public void setFile(String file) {
			this.file = file;
		}

		public String getPostdate() {
			return postdate;
		}

		public void setPostdate(String postdate) {
			this.postdate = postdate;
		}

		public String getPosttime() {
			return posttime;
		}

		public void setPosttime(String posttime) {
			this.posttime = posttime;
		}

		public String getEditdatr() {
			return editdatr;
		}

		public void setEditdatr(String editdatr) {
			this.editdatr = editdatr;
		}

		public String getEdittime() {
			return edittime;
		}

		public void setEdittime(String edittime) {
			this.edittime = edittime;
		}


}
