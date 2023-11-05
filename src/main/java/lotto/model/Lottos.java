package lotto.model;

import lotto.dto.LottoDto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<LottoResult> getLottoWinningResult(Lotto winningNumber, BonusNumber bonusNumber) {
        List<LottoResult> result = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int count = lotto.countMatches(winningNumber);
            boolean bonus = lotto.hasBonusNumber(bonusNumber);

            LottoResult lottoResult = LottoResult.create(count, bonus);
            result.add(lottoResult);
        }

        return result;
    }

    public List<LottoDto> toDtos() {
        return lottos.stream()
                .map(Lotto::toDto)
                .collect(Collectors.toList());
    }
}
