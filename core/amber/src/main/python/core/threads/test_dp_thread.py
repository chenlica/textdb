from time import sleep

import pytest
from queue import Queue
from typing import Iterable, Union

from core import DPThread, Tuple
from core.models.internal_queue import InputDataElement
from core.models.payload import DataFrame
from core.models.tuple import InputExhausted
from core.udf import UDFOperator
from edu.uci.ics.amber.engine.common import LinkIdentity, ActorVirtualIdentity


class TestDpTread:

    @pytest.fixture
    def mock_udf(self):
        class EchoOperator(UDFOperator):
            def process_texera_tuple(self, tuple_: Union[Tuple, InputExhausted], nth_child: int = 0) -> Iterable[Tuple]:
                if isinstance(tuple_, InputExhausted):
                    return []
                return [tuple_]

        return EchoOperator()

#     @pytest.fixture
#     def mock_link(self):
#
#         return LinkIdentity().parse("""Q
# 1FTwitterFullArchiveSearch-operator-8f3f1734-da3e-4f35-bc25-000dcf7f972bmainC
# 18SimpleSink-operator-2c82f72b-b8f1-47d9-8582-d33a95597fb1main""")
#
#     @pytest.fixture
#     def mock_input_data_element(self):
#         return InputDataElement(payload=DataFrame(frame=[Tuple()]),
#                                 from_=ActorVirtualIdentity())
#     @pytest.fixture
#     def input_queue(self):
#         return Queue()
#
#     @pytest.fixture
#     def output_queue(self):
#         return Queue()
#
#     @pytest.fixture
#     def dp_thread(self, input_queue, output_queue, mock_udf):
#         dp_thread = DPThread(input_queue, output_queue, mock_udf)
#         yield dp_thread
#         dp_thread.stop()
#
#     @staticmethod
#     def _test_data_input(dp_thread, input_queue, link, output_queue, n: int):
#         current_output_queue_size = output_queue.qsize()
#         current_output_tuple_count = dp_thread.output_tuple_count
#         for i in range(1, n + 1):
#
#             sleep(0.02)
#             assert dp_thread._current_input_link == link
#             assert input_queue.qsize() == 0
#             assert output_queue.qsize() == current_output_tuple_count + i
#             assert dp_thread.output_tuple_count == current_output_queue_size + i
#
#     @staticmethod
#     def _test_change_sender(dp_thread, input_queue, output_queue, link=LinkIdentity()) -> LinkIdentity:
#         current_output_queue_size = output_queue.qsize()
#         input_queue.put(SenderChangeMarker(link))
#         sleep(0.02)
#         assert dp_thread._current_input_link == link
#         assert input_queue.qsize() == 0
#         assert output_queue.qsize() == current_output_queue_size
#         return link
#
#     @staticmethod
#     def _test_end_marker(dp_thread, input_queue, output_queue):
#         current_output_queue_size = output_queue.qsize()
#         current_output_tuple_count = dp_thread.output_tuple_count
#         current_input_tuple_count = dp_thread.input_tuple_count
#         input_queue.put(EndMarker())
#
#         sleep(0.1)
#         assert output_queue.qsize() == current_output_queue_size
#         assert dp_thread.output_tuple_count == current_output_tuple_count
#         assert dp_thread.input_tuple_count == current_input_tuple_count
#
#     @staticmethod
#     def _test_end_of_all_marker(dp_thread, input_queue, output_queue):
#         current_output_queue_size = output_queue.qsize()
#         current_output_tuple_count = dp_thread.output_tuple_count
#         current_input_tuple_count = dp_thread.input_tuple_count
#         input_queue.put(EndOfAllMarker())
#
#         sleep(0.1)
#         assert output_queue.qsize() == current_output_queue_size
#         assert dp_thread.output_tuple_count == current_output_tuple_count
#         assert dp_thread.input_tuple_count == current_input_tuple_count
#
#     def test_dp_thread_can_start(self, dp_thread):
#         dp_thread.start()
#         assert dp_thread.is_alive()
#
#     def test_dp_thread_can_handle_sender_change_marker(self, input_queue, output_queue, dp_thread):
#         dp_thread.start()
#         self._test_change_sender(dp_thread, input_queue, output_queue)
#         self._test_change_sender(dp_thread, input_queue, output_queue)
#
#     def test_dp_thread_can_handle_data_messages(self, input_queue, output_queue, dp_thread):
#         dp_thread.start()
#         link = self._test_change_sender(dp_thread, input_queue, output_queue)
#         self._test_data_input(dp_thread, input_queue, link, output_queue, n=10)
#
#     def test_dp_thread_can_handle_change_of_sender_during_data_messages(self, input_queue, output_queue, dp_thread,
#                                                                         mock_link):
#         dp_thread.start()
#
#         # send some data from sender 1
#         link = self._test_change_sender(dp_thread, input_queue, output_queue)
#         self._test_data_input(dp_thread, input_queue, link, output_queue, n=10)
#
#         # change sender now
#         link2 = self._test_change_sender(dp_thread, input_queue, output_queue, link=mock_link)
#         self._test_data_input(dp_thread, input_queue, link2, output_queue, n=10)
#
#     def test_dp_thread_can_handle_end_marker(self, input_queue, output_queue, dp_thread):
#         dp_thread.start()
#
#         # send some data from sender 1
#         link = self._test_change_sender(dp_thread, input_queue, output_queue)
#         self._test_data_input(dp_thread, input_queue, link, output_queue, n=10)
#
#         # send end marker for sender 1
#         self._test_end_marker(dp_thread, input_queue, output_queue)
#
#         # send some data from sender 2
#         link2 = self._test_change_sender(dp_thread, input_queue, output_queue)
#         self._test_data_input(dp_thread, input_queue, link2, output_queue, n=10)
#
#         # send end marker for sender 2
#         self._test_end_marker(dp_thread, input_queue, output_queue)
#
#         sleep(0.5)
#         assert dp_thread.is_alive()
#
#     def test_dp_thread_can_handle_end_of_all_marker(self, input_queue, output_queue, dp_thread):
#         dp_thread.start()
#
#         # send some data from sender 1
#         link = self._test_change_sender(dp_thread, input_queue, output_queue)
#         self._test_data_input(dp_thread, input_queue, link, output_queue, n=10)
#
#         # send end marker for sender 1
#         self._test_end_marker(dp_thread, input_queue, output_queue)
#
#         # send some data from sender 2
#         link2 = self._test_change_sender(dp_thread, input_queue, output_queue)
#         self._test_data_input(dp_thread, input_queue, link2, output_queue, n=10)
#
#         # send end marker for sender 2
#         self._test_end_marker(dp_thread, input_queue, output_queue)
#
#         self._test_end_of_all_marker(dp_thread, input_queue, output_queue)
#
#         sleep(0.5)
#         assert not dp_thread.is_alive()