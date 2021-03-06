package yapp14th.co.kr.myplant.ui.main.tab1_home.domain.usecase

import buv.co.kr.base.rx.RxUseCase
import io.reactivex.Scheduler
import yapp14th.co.kr.myplant.ui.main.tab1_home.CDayVO
import yapp14th.co.kr.myplant.ui.main.tab1_home.domain.repository.HomeRepository

class GetComments(val homeRepository: HomeRepository, val scheduler: Scheduler) : RxUseCase() {
    operator fun invoke(
            year: Int,
            month: Int,
            success: (years: List<CDayVO>) -> Unit,
            error: (throwable: Throwable) -> Unit
    ) {
        disposable = homeRepository.getComments(
                year = year,
                month = month,
                scheduler = scheduler,
                success = success,
                error = error
        )
    }
}