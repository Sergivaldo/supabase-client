package junior.sergivaldo.services.bucket;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bucket {
    private String id;
    private String name;
    @JsonProperty(value = "public")
    private Boolean isPublic;
    @JsonProperty(value = "file_size_limit", access = JsonProperty.Access.READ_ONLY)
    private String fileSizeLimit;
    @JsonProperty(value = "file_size_limits", access = JsonProperty.Access.WRITE_ONLY)
    private List<String> fileSizeLimits;
    @JsonProperty(value = "allowed_mime_types")
    private List<String> allowedMimeTypes;
    @JsonProperty(value = "created_at", access = JsonProperty.Access.READ_ONLY)
    private String createdAt;
    @JsonProperty(value = "updated_at", access = JsonProperty.Access.READ_ONLY)
    private String updatedAt;
    @JsonProperty( access = JsonProperty.Access.READ_ONLY)
    private String owner;

    @Override
    public String toString() {
        return "Bucket{" +
                "  id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isPublic=" + isPublic +
                ", fileSizeLimit='" + fileSizeLimit + '\'' +
                ", fileSizeLimits=" + fileSizeLimits +
                ", allowedMimeTypes=" + allowedMimeTypes +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }

}
