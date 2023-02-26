package data;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StudentBuilder {
        private String name;
        private String position;
        private String country;

}
