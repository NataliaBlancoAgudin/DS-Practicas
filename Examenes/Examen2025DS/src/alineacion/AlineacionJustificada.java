package alineacion;

import model.Line;

public class AlineacionJustificada implements Alineacion {

    @Override
    public String alinear(Line line, int lineWidth) {
        return createJustifiedLine(line, lineWidth);
    }

    private String createJustifiedLine(Line line, int lineWidth) {
        var builder = new StringBuilder();
        var totalSpacesNeeded = lineWidth - line.numberOfCharacters();

        // Compute the number of spaces per gap
        var spacesPerGap = Math.max(1, totalSpacesNeeded / line.numberOfGaps());
        // The remaining spaces are distributed from left to right
        var extraSpaces = Math.max(0, totalSpacesNeeded - (spacesPerGap * line.numberOfGaps()));

        for (int i = 0; i < line.getWords().size(); i++) {
            builder.append(line.getWord(i));

            if (i < line.numberOfWords() - 1) {
                builder.append(" ".repeat(spacesPerGap));

                if (extraSpaces > 0) {
                    builder.append(" ");
                    extraSpaces--;
                }
            }
        }

        return builder.toString();
    }
}
