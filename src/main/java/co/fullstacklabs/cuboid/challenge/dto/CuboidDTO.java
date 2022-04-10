package co.fullstacklabs.cuboid.challenge.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CuboidDTO {
    private Long id;

    @NotNull(message = "Cuboid width can't be null.")
    private Float width;

    @NotNull(message = "Cuboid height can't be null.")
    private Float height;

    @NotNull(message = "Cuboid depth can't be null.")
    private Float depth;

    private Double volume;

    @NotNull(message = "Cuboid related bag can't be null.")
    private Long bagId;

    /**
     * Calculate the volume of the cuboid
     *
     * @return the calculated cuboid volume
     */
    public Double getVolume() {
        if (width == null && height == null && depth == null) return 0.0;
        return (double) width * height * depth;
    }
}
