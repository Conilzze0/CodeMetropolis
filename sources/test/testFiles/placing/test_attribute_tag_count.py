from conftest import count_tags
from conftest import ATTRIBUTE

jar = 'placing'

def test_attribute_tags_count(expected_xml, placing_output_xml):

    expected_count = count_tags(expected_xml, ATTRIBUTE)
    output_count = count_tags(placing_output_xml, ATTRIBUTE)

    assert expected_count == output_count, f"test_attribute_tags_count: The number of 'attribute' tags does not match. Expected {expected_count}, but got {output_count} tags."

