package yapp14th.co.kr.myplant.ui.main.tab1_home.domain.repository

import buv.co.kr.ui.login.data.HomeMockSource
import yapp14th.co.kr.myplant.ui.main.tab1_home.data.HomeRemoteSource
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import yapp14th.co.kr.myplant.ui.main.tab1_home.CDayVO
import yapp14th.co.kr.myplant.ui.main.tab1_home.CalendarMonth

class HomeRepositoryImpl : HomeRepository {
    val mockHomeSource = HomeMockSource()
    val remoteHomeSource = HomeRemoteSource()

    override fun getYears(currentYear: Int, scheduler: Scheduler, success: (years: List<Int>) -> Unit, error: (throwable: Throwable) -> Unit): Disposable {
        return remoteHomeSource.getYears(currentYear)
                .subscribeOn(scheduler)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ years ->
                    success(years)
                })
                { t ->
                    error(t)
                }
    }

//    override fun getCalendars(year: Int, scheduler: Scheduler, success: (calendars: List<Pair<Int, Int>>) -> Unit, error: (throwable: Throwable) -> Unit): Disposable {
//        return mockHomeSource.getCalendars(year)
//                .subscribeOn(scheduler)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({ calendars ->
//                    success(calendars)
//                })
//                { t ->
//                    error(t)
//                }
//    }

    override fun getYearEmotions(year: Int, scheduler: Scheduler, success: (emotions: List<CalendarMonth>) -> Unit, error: (throwable: Throwable) -> Unit): Disposable {
        return remoteHomeSource.getYearEmotions(year)
                .subscribeOn(scheduler)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ emotions ->
                    success(emotions)
                })
                { t ->
                    error(t)
                }
    }

    override fun getAllEmotions(scheduler: Scheduler, success: (emotions: List<CalendarMonth>) -> Unit, error: (throwable: Throwable) -> Unit): Disposable {
        return remoteHomeSource.getAllEmotions()
            .subscribeOn(scheduler)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ emotions ->
                success(emotions)
            })
            { t ->
                error(t)
            }
    }

    override fun getComments(year: Int, month: Int, scheduler: Scheduler, success: (emotions: List<CDayVO>) -> Unit, error: (throwable: Throwable) -> Unit): Disposable {
        return remoteHomeSource.getComments(year, month)
                .subscribeOn(scheduler)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ comments ->
                    success(comments)
                })
                { t ->
                    error(t)
                }
    }
}
