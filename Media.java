
public abstract class Media<T> {
		private String title;
		private String creator;
		private int year;
		private int duration;
		protected T rating;
		
		public Media(String title, String creator, int year, int duration) {
			setTitle(title);
			setCreator(creator);
			setYear(year);
			setDuration(duration);
			
			
		}
		
		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			if (title == null || title.isBlank()) {
				throw new IllegalArgumentException("Title cannot be null or blank");
			}
			this.title = title;
		}
		
		public String getCreator() {
			return creator;
		}

		public void setCreator(String creator) {
			if (creator == null || creator.isBlank()) {
				throw new IllegalArgumentException("Creator cannot be null or blank");
			}
			this.creator = creator;
		}
		
		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			if (year < 1800 || year > 2024) {
				throw new IllegalArgumentException("Year must be between 1800 and 2024");
			}
			this.year = year;
		}
		
		public int getDuration() {
			return duration;
		}

		public void setDuration(int duration) {
			if (duration < 0) {
				throw new IllegalArgumentException("Duration must be greater that 0");
			}
			this.duration = duration;
		}
		
		public T getRating() {
			return rating;
		}
		
		public void setRating(T rating) {
			this.rating = rating;
		}
		
	}
