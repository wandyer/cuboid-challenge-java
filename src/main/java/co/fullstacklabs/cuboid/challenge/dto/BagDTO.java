package co.fullstacklabs.cuboid.challenge.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

import co.fullstacklabs.cuboid.challenge.model.Bag;

import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BagDTO {
    private Long id;

    @NotNull(message = "Bag volume can't be null.")
    private Double volume;

    @NotNull(message = "Bag title can't be null.")
    @Size(min = 1, max = Bag.TITLE_MAX_SIZE, message = "Bag title maximum size is " + Bag.TITLE_MAX_SIZE + " characters.")
    private String title;
    private Double payloadVolume;
    private Double availableVolume;
    private List<CuboidDTO> cuboids;

    /**
     * Calculate the total payload volume of the cuboids
     *
     * @return the calculated total payload volume
     */
    public Double getPayloadVolume() {
        return cuboids.stream().mapToDouble(CuboidDTO::getVolume).sum();
    }

    /**
     * Calculate the total available space of the bag
     *
     * @return the calculated available space
     */
    public Double getAvailableVolume() {
        return volume - getPayloadVolume();
    }
}
