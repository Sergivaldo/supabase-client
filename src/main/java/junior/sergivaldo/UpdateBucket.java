package junior.sergivaldo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class UpdateBucket {

    @JsonProperty(value = "public")
    private Boolean isPublic;
    @JsonProperty(value = "file_size_limit")
    private String fileSizeLimit;
    @JsonProperty(value = "allowed_mime_types")
    private List<String> allowedMimeTypes;

    @Override
    public String toString() {
        return "UpdateBucket{" +
                "isPublic=" + isPublic +
                ", fileSizeLimit='" + fileSizeLimit + '\'' +
                ", allowedMimeTypes=" + allowedMimeTypes +
                '}';
    }

}
