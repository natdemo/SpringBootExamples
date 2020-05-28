package books.vediclibrary.model;

public class Author {

	private String authorName;
	private String yearLived;

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getYearLived() {
		return yearLived;
	}

	public void setYearLived(String yearLived) {
		this.yearLived = yearLived;
	}

	@Override
	public String toString() {
		return "Author [authorName=" + authorName + ", yearLived=" + yearLived + "]";
	}

}
