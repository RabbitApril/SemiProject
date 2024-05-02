<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section>
                <div class="read area">
                    <div class="btn function">
                        <div>
                            <button class="btn update">수정</button>
                        </div>
                        <div>
                            <button class="btn delete">삭제</button>
                        </div>
                    </div>
                    <div class="readwrite">
                        <div class="boardtitle">
                            제목 확인용
                        </div>
                        <div class="boardfile">
                            파일 표시
                        </div>
                        <div class="boardcontent">
                            대법원은 법률에 저촉되지 아니하는 범위안에서 소송에 관한 절차, 법원의 내부규율과 사무처리에 관한 규칙을 제정할 수 있다. 선거에 관한 경비는 법률이 정하는 경우를
                            제외하고는 정당 또는 후보자에게 부담시킬 수 없다. 모든 국민은 인간다운 생활을 할 권리를 가진다. 대법관은 대법원장의 제청으로 국회의 동의를 얻어 대통령이
                            임명한다.

                            위원은 정당에 가입하거나 정치에 관여할 수 없다. 대통령은 취임에 즈음하여 다음의 선서를 한다. 공무원인 근로자는 법률이 정하는 자에 한하여 단결권·단체교섭권 및
                            단체행동권을 가진다. 헌법재판소의 조직과 운영 기타 필요한 사항은 법률로 정한다. 대통령은 제4항과 제5항의 규정에 의하여 확정된 법률을 지체없이 공포하여야 한다.
                            제5항에
                            의하여 법률이 확정된 후 또는 제4항에 의한 확정법률이 정부에 이송된 후 5일 이내에 대통령이 공포하지 아니할 때에는 국회의장이 이를 공포한다.
                        </div>
                    </div>
                </div>
                <hr class="gap1">
                <div class="reply area">
                    <form id="frm-reply">
                        <input type="hidden" name="boardId">
                        <div class="reply">
                            <div>
                                <input type="text" name="boardReplyContent" class="replycontentwrite" required>
                                <button type="button" class="btn reply">전송</button>
                            </div>
                        </div>
                    </form>
                </div>
                <hr class="gap2">
                <div class="reply-wrap">
                    <div class="replyread-wrap">
                        <div class="replywriter">테스트</div>
                        <div class="replycontent">테스트 내용</div>
                        <button type="button" class="btn show rreplycontent">댓글 더보기</button>
                    </div>
                    <div class="rreplycontent span">
                        <input type="text" name="boardReplyContent" class="boardReplyContent">
                        <button type="button" class="btn rreplay">등록</button>
                    </div>
                </div>
            </section>